#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

typedef struct{
	int n1;
	int n2;
} data;

void* thread(void*);
int sommatore(data*);

int main(int argc, char** argv){
	
	/*
	Controllo del corretto utilizzo del comando
	da parte dell'utente
	*/
	if(argc != 3){
		printf("USAGE: %s number number \n", *(argv));
		return -1;
	}
	
	/*
	Conversione delle stringhe date 
	in input in valori interi e creazione
	della variabile contenente il risultato
	*/
	int n1 = atoi(*(argv + 1));
	int n2 = atoi(*(argv + 2));
	int* ris;
	
	/*
	Creazione della struttura e 
	inserimento dei dati di input
	*/
	data dati;

	dati.n1 = n1;
	dati.n2 = n2;
	
	/*
	Creazione dell'id del thread e 
	richiamo attraverso l'apposita funzione pthread_create,
	con controllo di errori nella creazione
	*/
	printf("Main: Creo il thread e lo eseguo...\n");
	pthread_t id;
	int r = pthread_create(&id, NULL, thread, (void*) &dati);
	if (r != 0) {
		printf("Errore: creazione del thread non riuscita...\n");
		return -2;
	}
	
	/*
	Attesa del termine del thread e 
	restituzione del valore calcolato
	*/
	printf("Main: Ora attendo la sua fine...\n");
	pthread_join(id, (void**) &ris);

	/*
	Output del risultato
	*/	
	printf("Main: Il thread ha terminato e il risultato della somma è %d\n", (int) *ris);
	
	/*
	Rimozione dell'allocazione in memoria 
	creata dal thread
	*/ 
	printf("Main: Pulisco la memoria...\n");
	free(ris);
	return 0;
}

void* thread(void* p){
	data* dati = (data*) p;
	/*
	Allocazione di uno spazio in memoria per non
	perdere il risultato una volta terminato il thread
	*/
	printf("Thread: Creo uno spazio in memoria nel quale inserire il risultato del calcolo...\n");
	int* ret = (int*) malloc(sizeof(int));
	
	printf("Thread: Eseguo la somma dei due valori forniti...\n");
	*(ret) = sommatore(dati);
	
	printf("Thread: Ho finito!\n");
	pthread_exit(ret);
}

int sommatore(data* dati){
	int ret = dati -> n1 + dati -> n2;
	return ret;
}
